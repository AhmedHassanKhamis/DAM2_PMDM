package com.cursoandroid.retrofitcomposeapp.di

import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import com.cursoandroid.retrofitcomposeapp.data.GameApi
import com.cursoandroid.retrofitcomposeapp.util.Constantes.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


// cada vez que en algún sitio se requiera Retrofit, como por ejemplo en
// la interface, automáticamente se proveerá este singleton, o sea la misma instancia de retrofit
// la interface GameApi provee la conexión remota a este recurso con @GET

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //esta clase para que siempre que se requiera retrofit se use siempre la misma instancia

    @Singleton
    @Provides
        fun povidesRetrofit(): GameApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameApi::class.java)

    }

}