package test.com.testapp.ui;

import java.util.List;

import test.com.testapp.base.BaseView;
import test.com.testapp.modal.Post;

public interface TestView extends BaseView {

    void updatePosts(List<Post> posts);

    void showError(String error);

    void showLoading();

    void hideLoading();
}
