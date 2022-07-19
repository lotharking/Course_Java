package com.curse.app.ws.photoapp.api.users.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.curse.app.ws.photoapp.api.users.ul.model.AlbumResponseModel;

/**
 * @interface AlbumsServiceClient
 * @Description: this interface callback the albums micro service
 * 				and it is necessary so that there can be communication 
 * 				with the api of the albums microservice
 */
@FeignClient(name = "albums-ws")
public interface AlbumsServiceClient {
	
	@GetMapping(path = "/users/{id}/albums")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);

}