<p align="center"><img src="images/workflow.png"></p>
<h1 align="center">UserLogin App with Dagger2</h1>

## App Goal:
This opensource project is a demonstration of how we can login a user and display his/ her Profile and list of Posts and control it's session using SessionManager

## Project Used:
* Android Studio 3.5.3
* Kotlin Version 1.3.40

## Compatibility
This demo is expected to run in between minSdkVersion 17 to targetSdkVersion 29.

## Libraries Used:
* Dagger 2.2+ (Focus on Dagger-Android)
* Lifecycle Components (ViewModel, LiveData and ReactiveStreams)
* RxJava
* Retrofit2
* Android Jetpack Libraries

## Design patterns:
### MVVM:
MVVM stands for Model,View,ViewModel in which controllers, views and animations take place in View and Business logics, api calls take place in ViewModel. In fact this layer is interface between model and View and its going to provide data to View as it wants. 

## Dagger2 in Kotlin:
Dagger2 configuration in Kotlin is a bit tricky and it's difficult to configure it when viewmodel is involved. We have to create a seperate ViewModelProviderFactory class inorder to inject into ViewModel as VM doesn't suport constructor injection by default.

```
class ViewModelProviderFactory
@Inject
constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}
```

After creating a ViewModelProviderFactory class, we have to define it inside ViewModelFactoryModule class.

```
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}
```

ViewModelFactoryModule have to define it in AppComponent class on Application level so that we could be injected it on our ViewModels.

```
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent {

    /**
     * Session manager can be access any where in the application
     */
    fun sessionManager() : SessionManager

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}
```
## RxJava and LiveData
This project uses RxJava to define an observable and handle asynchronous network operation with Retrofit2 and also uses it to handle the user session then turn all our observables into Flowable constructs to use it in our ViewModel.

 ## TODO:
 - Flexible Design for multiple screen sizes.
 - Improve UI for good user interface, Keep the interface simple.
 - Cover edge case in Unit test
 - UI Test with Espresso and Mockk
 - JUnit5 Test






