package com.algolia.search.model.search

import com.algolia.search.model.Raw
import com.algolia.search.serialize.KeyMatchAlternatives
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(ExplainModule.Companion::class)
public sealed class ExplainModule(override val raw: String) : Raw<String> {

    public object MatchAlternatives : ExplainModule(KeyMatchAlternatives)

    public data class Other(override val raw: String) : ExplainModule(raw)

    public companion object : KSerializer<ExplainModule> {

        private val serializer = String.serializer()

        override val descriptor: SerialDescriptor = serializer.descriptor

        override fun serialize(encoder: Encoder, value: ExplainModule) {
            serializer.serialize(encoder, value.raw)
        }

        override fun deserialize(decoder: Decoder): ExplainModule {
            return when (val string = serializer.deserialize(decoder)) {
                KeyMatchAlternatives -> MatchAlternatives
                else -> Other(string)
            }
        }
    }
}
