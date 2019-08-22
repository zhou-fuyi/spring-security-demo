package com.imooc.wiremock;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.core.io.ClassPathResource;

import com.github.tomakehurst.wiremock.client.WireMock;

public class MockServer {

	public static void main(String[] args) throws IOException {
		WireMock.configureFor(8068);//本地服务, 没有指定IP
		WireMock.removeAllMappings();//清除所有配置
		
		mock("/order/1", "001");
		mock("/order/2", "002");
		
	}

	private static void mock(String url, String fileName) throws IOException {
		// TODO Auto-generated method stub
		ClassPathResource resource = new ClassPathResource("mock/response/" + fileName + ".txt");
		String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8"));
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url))
				.willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
	}
	
}
