package com.ravimhzn.daggerinkotlin.baseapp

class DummyClass(private val firstname: String, var age: Int) {

    init {
        this.age = age + 10
        println("After changing:: $age")
    }


    fun dummyFun() {
        println("FirstName:: $firstname")
        println("Age:: $age")
    }

}

fun main(args: Array<String>) {
    println(stringCount("PPAAALL"))
}

fun stringCount(value: String): Boolean {
    val charArr = value.toCharArray()
    var aCount = charArr.count { it == 'A' }
    var lCount = charArr.count { it == 'L' }

    if (aCount == 0 && lCount == 1) {
        return true
    } else if (aCount == 0 && lCount == 2) {
        return true
    } else if (aCount == 1 && lCount == 0) {
        return true
    } else if (aCount == 1 && lCount == 1) {
        return true
    } else return aCount == 1 && lCount == 2


    for (i in 0..aCount) {
        for (j in 0..2) {
        }
    }


    return false
}


class HammingDistance(var a: Int, var b: Int) {

    fun hammingDistance(): Int {
        var x: Int = a xor b
        var setBits = 0

        while (x > 0) {
            setBits += x and 1
            x = x shr 1
        }



        return setBits
    }
}

/**
 *JUNK
//    fun testHttpConnectionWithRetrofit() {
//        authLoginAPI.getUser(5)
//            .toObservable()
//            .subscribeOn(Schedulers.io())
//            .subscribe(object : Observer<User> {
//                override fun onComplete() {
//
//                }
//
//                override fun onSubscribe(d: Disposable) {
//
//                }
//
//                override fun onNext(t: User) {
//                    Log.d(TAG, "EMAIL :: ${t.email}")
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.d(TAG, "ERROR OCCURRED :: $e")
//                }
//            })
//    }



/**
 * Workaround without the use of MediatorLiveData
*/
//    fun authenticateWithId(userId: Int): LiveData<User> {
//        return LiveDataReactiveStreams.fromPublisher(
//            authLoginAPI.getUser(userId).subscribeOn(
//                Schedulers.io()
//            )
//        )
//    }


private fun withoutUsingMediatorLiveData() {
viewModel.authenticateWithId(Integer.parseInt(etUserId.text.toString()))
.observe(this,
Observer<User> { t -> Log.d(TAG, "EMAIL::: (WITHOUT MLV) ${t?.email}") })
}
 */

