package com.yinlu.system.common.swagger.config;

import com.yinlu.system.common.swagger.support.SwaggerProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 *
 * <p>
 * 禁用方法1：使用注解@Profile({"dev","test"})
 *
 * 表示在开发或测试环境开启，而在生产关闭。（推荐使用） 禁用方法2：使用注解@ConditionalOnProperty(name = "swagger.enable",
 *
 * havingValue = "true") 然后在测试配置或者开发配置中添加swagger.enable=true即可开启，生产环境不填则默认关闭Swagger.
 * </p>
 *
 */
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration {

	/**
	 * 默认的排除路径，排除Spring Boot默认的错误处理路径和端点
	 */
	private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

	private static final String BASE_PATH = "/**";

	@Bean
	public Docket api(SwaggerProperties swaggerProperties) {
		// base-path处理
		if (swaggerProperties.getBasePath().isEmpty()) {
			swaggerProperties.getBasePath().add(BASE_PATH);
		}

		// exclude-path处理
		if (swaggerProperties.getExcludePath().isEmpty()) {
			swaggerProperties.getExcludePath().addAll(DEFAULT_EXCLUDE_PATH);
		}
		List<Predicate<String>> excludePath = new ArrayList<>();
		swaggerProperties.getExcludePath().forEach(path -> excludePath.add(PathSelectors.ant(path)));

		// 版本请求头处理
		List<RequestParameter> pars = new ArrayList<>();

		RequestParameterBuilder versionPar = new RequestParameterBuilder().description("灰度路由版本信息")
				.in(ParameterType.HEADER).name("VERSION").required(false)
				.query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)));

		pars.add(versionPar.build());

		ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2).host(swaggerProperties.getHost())
				.apiInfo(apiInfo(swaggerProperties)).globalRequestParameters(pars).select()
				.apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()));

		swaggerProperties.getBasePath().forEach(p -> builder.paths(PathSelectors.ant(p)));
		swaggerProperties.getExcludePath().forEach(p -> builder.paths(PathSelectors.ant(p).negate()));

		return builder.build()
				.pathMapping("/");
	}






	private static ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
		return new ApiInfoBuilder().title(swaggerProperties.getTitle()).description(swaggerProperties.getDescription())
				.termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
				.contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(),
						swaggerProperties.getContact().getEmail()))
				.version(swaggerProperties.getVersion()).build();
	}

}
