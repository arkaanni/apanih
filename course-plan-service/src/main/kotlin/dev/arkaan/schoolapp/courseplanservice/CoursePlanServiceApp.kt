package dev.arkaan.schoolapp.courseplanservice

import com.google.inject.Guice
import dev.arkaan.schoolapp.courseplanservice.resources.CoursePlanResource
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.core.Application
import io.dropwizard.core.setup.Bootstrap
import io.dropwizard.core.setup.Environment

class CoursePlanServiceApp : Application<CoursePlanServiceConfiguration>() {

    override fun initialize(bootstrap: Bootstrap<CoursePlanServiceConfiguration>?) {
        super.initialize(bootstrap)

        val substitutor = EnvironmentVariableSubstitutor()
        bootstrap?.apply {
            configurationSourceProvider = SubstitutingSourceProvider(
                configurationSourceProvider, substitutor
            )
        }
    }

    override fun run(configuration: CoursePlanServiceConfiguration, environment: Environment) {
        val injector = Guice.createInjector(AppModule(configuration, environment))
        val coursePlanResource = injector.getInstance(CoursePlanResource::class.java)
        environment.jersey().apply {
            register(coursePlanResource)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CoursePlanServiceApp().run(*args)
        }
    }
}


