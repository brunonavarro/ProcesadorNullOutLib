package com.bruno.daniel.navarro.nunez.procesadornulloutlib.procesador

import com.bruno.daniel.navarro.nunez.decoradorlib.decoradores.NullOutEntity
import com.squareup.kotlinpoet.asTypeName
import org.jetbrains.annotations.Nullable
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import javax.tools.Diagnostic

/*
@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
//@SupportedOptions(KaptJavacTask::class.java.name)
class DecoradorProcesadorNullOutEntity : AbstractProcessor() {
    private lateinit var elementUtils: Elements
    private lateinit var typeUtils: Types

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        elementUtils = processingEnv.elementUtils
        typeUtils = processingEnv.typeUtils
    }

    override fun getSupportedAnnotationTypes(): Set<String> {
        return setOf(NullOutEntity::class.java.canonicalName)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(
        annotations: MutableSet<out TypeElement>?,
        roundEnv: RoundEnvironment?
    ): Boolean {
        roundEnv?.getElementsAnnotatedWith(NullOutEntity::class.java)?.forEach { element ->
            // Verificar que es una clase
            if (element.kind != ElementKind.CLASS) {
                processingEnv.messager.printMessage(Diagnostic.Kind.ERROR,
                    "La anotación NullOutEntity solo puede aplicarse a clases.", element)
                return true
            }

            // Verificar características de una data class
            if (!isDataClass(element)) {
                processingEnv.messager.printMessage(Diagnostic.Kind.ERROR,
                    "La anotación NullOutEntity solo puede aplicarse a data classes.", element)
                return true
            }

            element.enclosedElements
                .filter { it.kind == ElementKind.FIELD }
                .forEach { field ->
                    field.annotationMirrors?.forEach {
                        if (it.annotationType.toString() != Nullable::class.java.getName()) {
                            // Haz algo con la anotación Nullable
                            processingEnv.messager.printMessage(Diagnostic.Kind.ERROR,
                            "Field ${field.simpleName} in class ${element.simpleName} must be nullable!")
                        }
                    }
                }

//            element.enclosedElements
//                .filter { it.kind == ElementKind.FIELD }
//                .forEach { field ->
//                    val isNullable = field.asType().toString().endsWith("?")
//                    processingEnv.messager.printMessage(Diagnostic.Kind.WARNING,
//                        "Field asType ${field.asType().toString()}")
//                    if (!isNullable) {
//                        processingEnv.messager.printMessage(Diagnostic.Kind.ERROR,
//                            "Field ${field.simpleName} in class ${element.simpleName} must be nullable!")
//                    }
//                }



//            // Acceder a los métodos getter de cada atributo y verificar si son nullables
//            element.enclosedElements.forEach { enclosedElement ->
//                if (enclosedElement.kind == ElementKind.METHOD && enclosedElement.simpleName.toString().startsWith("get")) {
//                    val returnType = (enclosedElement as ExecutableElement).returnType
//                    processingEnv.messager.printMessage(Diagnostic.Kind.WARNING,
//                        "return type. ${returnType.kind.toString()}")
//                    if (!returnType.toString().endsWith("?")) {
//                        processingEnv.messager.printMessage(Diagnostic.Kind.ERROR, "Todos los atributos de la data class deben ser nullables: ${enclosedElement.simpleName}.", element)
//                        return false
//                    }
//                }
//            }


//            for (enclosedElement in enclosedElements) {
//                processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, "enclosedElement : $enclosedElement")
//                if (enclosedElement.kind == ElementKind.FIELD) {
//                    processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, "enclosedElement is ElementKind.FIELD")
//
//                    val variableElement = enclosedElement as VariableElement
//                    processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, "variableElement : $variableElement")
//
//                    processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, "variableElement constantValue : ${variableElement.constantValue}")
//                    processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, "variableElement modifiers : ${variableElement.modifiers}")
//
//                    if (!hasDefaultValue(variableElement)) {
//                        processingEnv.messager.printMessage(Diagnostic.Kind.ERROR,
//                            "Todos los atributos de la data class deben tener valores predeterminados.", variableElement)
//                        return true
//                    }
//                }
//            }
        }
        return true
    }

    private fun hasDefaultValueOrIsNullable(variableElement: VariableElement): Boolean {
        val modifiers = variableElement.modifiers
        val type = variableElement.asType()
        return modifiers.contains(Modifier.FINAL) || type.kind.isPrimitive || type.toString().endsWith("?")
    }

    private fun hasDefaultValue(variableElement: VariableElement): Boolean {
        // Verificar si el campo tiene un valor predeterminado (inicializador)
        processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, "variableElement simpleName : ${variableElement.simpleName}")
        processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, "variableElement modifiers : ${variableElement.modifiers}")
        return variableElement.modifiers.toString().contains("=")
    }

    private fun isDataClass(element: Element): Boolean {
        // Comprobar si la clase tiene el método 'copy', un método típico de las data classes
        val hasCopyMethod = element.enclosedElements.any {
            it.kind == ElementKind.METHOD && it.simpleName.toString() == "copy"
        }
        // Comprobar si la clase tiene un constructor principal con parámetros
        val hasPrimaryConstructor = element.enclosedElements.any {
            it.kind == ElementKind.CONSTRUCTOR && it is ExecutableElement && it.parameters.isNotEmpty()
        }
        return hasCopyMethod && hasPrimaryConstructor
    }
}
*/

//@AutoService(Processor::class)
//class DecoradorProcesadorNullOutEntity : AbstractProcessor() {
//    private lateinit var elementUtils: Elements
//    private lateinit var typeUtils: Types
//
//    override fun init(processingEnv: ProcessingEnvironment) {
//        super.init(processingEnv)
//        elementUtils = processingEnv.elementUtils
//        typeUtils = processingEnv.typeUtils
//    }
//
//    override fun getSupportedAnnotationTypes(): Set<String> {
//        return setOf(NullOutEntity::class.java.canonicalName)
//    }
//
//    override fun getSupportedSourceVersion(): SourceVersion {
//        return SourceVersion.latestSupported()
//    }
//
//    override fun process(
//        annotations: MutableSet<out TypeElement>?,
//        roundEnv: RoundEnvironment?
//    ): Boolean {
//        roundEnv?.getElementsAnnotatedWith(NullOutEntity::class.java)?.forEach { element ->
//            // Verificar que es una data class
//            if (!element.toString().startsWith("data class")) {
//                processingEnv.messager.printMessage(Diagnostic.Kind.ERROR,
//                    "La anotación NullOutEntity solo puede aplicarse a data classes.")
//                return false
//            }
//
//            // Verificar que todos los atributos están inicializados
//            element.enclosedElements.forEach { enclosedElement ->
//                if (enclosedElement.asType().kind.isPrimitive && enclosedElement.simpleName.toString() == "null") {
//                    processingEnv.messager.printMessage(Diagnostic.Kind.ERROR,
//                        "Todos los atributos de la data class deben estar inicializados.")
//                    return false
//                }
//            }
//        }
//        return true
//    }
//}