package com.qa.upgrade.common.abstraction;

import com.qa.upgrade.utils.common.WResponse;

public interface IRestClient {
	
	public WResponse get(String path);

}