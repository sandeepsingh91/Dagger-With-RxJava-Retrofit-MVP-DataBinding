package test.com.testapp.base;

import test.com.testapp.components.DaggerPresenterComponent;
import test.com.testapp.components.PresenterComponent;
import test.com.testapp.module.ContextModule;
import test.com.testapp.module.NetworkModule;

public abstract class BasePresenter<T extends BaseView, V> {


    public T view;
    private PresenterComponent injector;

    public BasePresenter(T view) {

        this.view = view;

        injector = DaggerPresenterComponent
                .builder()
                .baseView(this.view)
                .contextModule(new ContextModule())
                .networkModule(new NetworkModule())
                .build();

        this.inject(injector);
    }

    public void onViewCreated() {

    }

    public void onViewDestoryed() {

    }

    public abstract void inject(PresenterComponent injector);

    public final BaseView getView() {
        return view;
    }
}
