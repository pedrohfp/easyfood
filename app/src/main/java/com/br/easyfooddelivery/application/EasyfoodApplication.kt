package com.br.easyfooddelivery.application

import android.app.Application
import com.br.easyfooddelivery.di.Injection
import com.github.salomonbrys.kodein.KodeinAware

class EasyfoodApplication : Application(), KodeinAware {
    override val kodein by Injection(this, "teste").graph
}
