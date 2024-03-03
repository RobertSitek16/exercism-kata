package accumulate

class Accumulate {

    static accumulate(Collection collection, Closure func) {
        def result = []
        collection.each { obj ->
            def transformedObj = func(obj)
            result << transformedObj
        }
        return result
    }

}
