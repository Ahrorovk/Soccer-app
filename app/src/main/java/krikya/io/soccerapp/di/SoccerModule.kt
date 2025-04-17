package krikya.io.soccerapp.di
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import krikya.io.soccerapp.core.Constants.BASE_URL
import krikya.io.soccerapp.data.SoccerRepositoryImpl
import krikya.io.soccerapp.data.local.SoccerDatabase
import krikya.io.soccerapp.data.network.SoccerApi
import krikya.io.soccerapp.domain.SoccerRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object SoccerModule {
    @Singleton
    @Provides
    fun provideSoccerApi(): SoccerApi =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .readTimeout(150, TimeUnit.SECONDS)
                    .connectTimeout(150, TimeUnit.SECONDS)
                    .build()
            )
            .build()
            .create(SoccerApi::class.java)

    @Singleton
    @Provides
    fun provideSoccerRepository(soccerApi: SoccerApi):SoccerRepository = SoccerRepositoryImpl(soccerApi)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SoccerDatabase {
        return Room.databaseBuilder(
            context,
            SoccerDatabase::class.java,
            "soccer_database"
        ).fallbackToDestructiveMigration().build()
    }
}