package com.bruno.daniel.navarro.nunez.procesadornulloutlib.procesador

import com.bruno.daniel.navarro.nunez.decoradorlib.decoradores.NullOutEntity
import com.google.devtools.ksp.containingFile
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.FileSpec
import com.google.devtools.ksp.symbol.Modifier
import com.google.devtools.ksp.symbol.Nullability
import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*


//@AutoService(Processor::class)
//@SupportedSourceVersion(SourceVersion.RELEASE_8)
////@SupportedOptions(KaptJavacTask::class.java.name)
class DecoradorProcesadorKSPNullOutEntity(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
): SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        resolver.getSymbolsWithAnnotation(
            annotationName = NullOutEntity::class.java.name
        ).filterIsInstance<KSClassDeclaration>().forEach(::processClass)
        return emptyList()
    }

    private fun processClass(
        clazz: KSClassDeclaration
    ) {
        logger.warn("Init processing class ${clazz.simpleName.asString()}")
        if (clazz.modifiers.contains(Modifier.DATA)) {
            clazz.getAllProperties().forEachIndexed { index, property ->
                val isNullable = property.type.resolve().nullability == Nullability.NULLABLE
                val param = clazz.primaryConstructor?.parameters?.get(index)

                logger.warn(
                    "El parametro ${property.simpleName.asString()} tiene default?: ${param?.hasDefault}, "
                )

                if (!isNullable) {
                    // No cumple con los requisitos
                    logger.error("El parametro ${property.simpleName.asString()}, " +
                            "debe admitir nulos")
                }
                if (param?.hasDefault == false) {
                    logger.error(
                        "El parametro ${property.simpleName.asString()}, " +
                                "debe tener un valor por default"
                    )
                }
            }
        }else{
            logger.error("La clase ${clazz.simpleName.asString()}, " +
                    "debe ser de tipo Data Class")
        }
    }

    private fun FileSpec.Builder.addImports(
        httpMethods: Array<String>
    ){
        listOf(
            "io.ktor.client.request" to httpMethods,
            "kotlinx.coroutines" to arrayOf("withContext", "Dispatchers"),
            "com.gucodero.ktorcito" to arrayOf("jsonBody", "setJsonBody", "KtorcitoURL"),
            "io.ktor.client.statement" to arrayOf("HttpResponse")
        ).forEach { (packageName: String, names: Array<String>) ->
            addImport(
                packageName = packageName,
                names = names
            )
        }
    }
}