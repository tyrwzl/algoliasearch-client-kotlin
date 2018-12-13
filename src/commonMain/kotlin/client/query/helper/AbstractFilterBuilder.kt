package client.query.helper


interface AbstractFilterBuilder<T : Filter> {

    operator fun Group.plusAssign(filter: T)

    operator fun Group.plusAssign(filters: Collection<T>)

    operator fun Group.minusAssign(filter: T)

    operator fun Group.minusAssign(filters: Collection<T>)

    fun Group.contains(filter: T): Boolean

    fun Group.clear(attribute: Attribute? = null)

    fun Group.replaceAttribute(attribute: Attribute, replacement: Attribute)

    fun Group.get(attribute: Attribute? = null): Set<T>

    fun clear()
}