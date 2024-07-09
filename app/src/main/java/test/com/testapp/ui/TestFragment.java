package test.com.testapp.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import test.com.testapp.R;
import test.com.testapp.base.BaseFragment;
import test.com.testapp.databinding.FragmentTestBinding;
import test.com.testapp.modal.Post;

public class TestFragment extends BaseFragment implements TestView {

    FragmentTestBinding binding;

    TestAdapter adapter;

    @Override
    public void hideLoading() {
        binding.setProgressVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        binding.setProgressVisibility(View.VISIBLE);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.onViewCreated();
    }

    @Override
    protected TestPresenter instantiatePresenter() {
        return new TestPresenter(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onViewDestoryed();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);



        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TestPresenter) presenter).onViewCreated();

        adapter = new TestAdapter(getContext());

        binding.setAdapter(adapter);
        binding.setLayoutManager(new LinearLayoutManager(getContext()));

        ((TestPresenter) presenter).loadPosts();
    }

    @Override
    public void updatePosts(List<Post> posts) {
        System.out.println("TestFragment.updatePosts");
        adapter.updatePosts(posts);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

}
