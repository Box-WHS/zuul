package one.klemm.box.zuul

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
class ZuulApplication

fun main(args: Array<String>) {
    SpringApplication.run(ZuulApplication::class.java, *args)
}

@Bean
fun corsFilter(): CorsFilter {
    var source: UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
    var config: CorsConfiguration = CorsConfiguration()

    config.allowCredentials = true
    config.run {
        addAllowedOrigin("*")
        addAllowedHeader("*")
        addAllowedMethod("OPTIONS")
        addAllowedMethod("HEAD")
        addAllowedMethod("GET")
        addAllowedMethod("PUT")
        addAllowedMethod("POST")
        addAllowedMethod("DELETE")
        addAllowedMethod("PATCH")
    }
    source.registerCorsConfiguration("/**", config)
    return CorsFilter(source)


}
