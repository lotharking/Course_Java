package com.curse.app.ws.photoapp.api.users.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.curse.app.ws.photoapp.api.users.ul.model.AlbumResponseModel;

/**
 * @interface AlbumsServiceClient
 * @Description: this interface callback the albums micro service
 * 				and it is necessary so that there can be communication 
 * 				with the api of the albums microservice
 * 				Nota: The name is the micro service name
 */
@FeignClient(name="albums-ws", fallback = AlbumsFallback.class)
public interface AlbumsServiceClient {
	
	/**
	 * @ApiName getAlbums
	 * @Description: this Api it is a reflection of the api in the micro 
	 * 				service of albums
	 */
	@GetMapping(path = "/users/{id}/albums")
	public List<AlbumResponseModel> getAlbums(@PathVariable("id") String id);

}

/** 
 * @Class AlbumsFallback
 * @Description Generate default values if the Feign class failure
 */
@Component
class AlbumsFallback implements AlbumsServiceClient
{

	@Override
	public List<AlbumResponseModel> getAlbums(String id) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	
}
