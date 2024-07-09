package test.com.testapp;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import test.com.testapp.modal.Post;

public interface PostApi {

    @GET("/posts")
    Observable<List<Post>> getPosts();
}