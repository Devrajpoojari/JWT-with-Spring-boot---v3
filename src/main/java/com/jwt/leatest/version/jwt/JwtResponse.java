package com.jwt.leatest.version.jwt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {


	private String jwtToken;
	
	private String message;

}
