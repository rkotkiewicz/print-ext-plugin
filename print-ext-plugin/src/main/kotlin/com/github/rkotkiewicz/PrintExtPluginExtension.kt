package com.github.rkotkiewicz

open class PrintExtPluginExtension {

    internal lateinit var propNames: Array<out String>

    fun include(vararg propNames: String){
        this.propNames = propNames;
    }

}