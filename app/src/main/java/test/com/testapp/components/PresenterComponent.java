package test.com.testapp.components;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import test.com.testapp.base.BaseView;
import test.com.testapp.module.ContextModule;
import test.com.testapp.module.NetworkModule;
import test.com.testapp.ui.TestPresenter;

@Singleton
@Component(modules = {ContextModule.class, NetworkModule.class})
public interface PresenterComponent {

    void inject(TestPresenter presenter);

    @Component.Builder
    public interface Builder {
        public PresenterComponent build();

        public Builder networkModule(NetworkModule networkModule);

        public Builder contextModule(ContextModule contextModule);

        @BindsInstance
        public Builder baseView(BaseView baseView);
    }
}
