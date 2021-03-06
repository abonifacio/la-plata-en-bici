package com.laplataenbici.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.laplataenbici.model.domain.utils.Rol;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Secured {
	Rol[] value() default {Rol.ADMIN,Rol.USER};
}
