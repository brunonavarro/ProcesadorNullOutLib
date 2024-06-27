package com.bruno.daniel.navarro.nunez.procesadornulloutlib.procesador

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class DecoradorProcesadorKSP: SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return DecoradorProcesadorKSPNullOutEntity(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
    }

}