package test.com.testapp.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import test.com.testapp.base.BaseView;

@Module
public class ContextModule {

    @Provides
    Application provideApplication(Context context) {
        return (Application) context.getApplicationContext();
    }
}
