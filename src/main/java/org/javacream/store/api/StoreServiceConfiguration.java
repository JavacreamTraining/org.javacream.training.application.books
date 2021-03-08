package org.javacream.store.api;

import org.javacream.store.decorators.AuditingStoreServiceDecorator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreServiceConfiguration {

	@Bean @Qualifier("withAuditing")  StoreService storeServiceWithAuditing(StoreService simpleStoreService) {
		AuditingStoreServiceDecorator auditingStoreServiceDecorator = new AuditingStoreServiceDecorator();
		auditingStoreServiceDecorator.setDelegate(simpleStoreService);
		return auditingStoreServiceDecorator;
	}
	@Bean @Qualifier("plain")  StoreService storeService(StoreService simpleStoreService) {
		return simpleStoreService;
	}
}