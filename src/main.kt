fun main() {

    var standardLibraryFun = SLFunctions();
    standardLibraryFun.also();
    standardLibraryFun.apply();
    standardLibraryFun.let();
    standardLibraryFun.run();
    standardLibraryFun.takeIf();
    standardLibraryFun.with();


    var infixFun = InfixFunctionsNotation();
    infixFun.SLInfixFunction();
    infixFun.UDInfixFunction();


    var memberFun = MemberFunctions();
    memberFun.inlineFunction(3,4);
    memberFun.lambdaFunction();
    memberFun.localFunction();


    var userDefinedFun = UserDefinedFunctions();
    userDefinedFun.anonymousFun();
    userDefinedFun.invoke();
    userDefinedFun.myFun();




}

//shortcut for standard library functions
class SLFunctions {


    //apply is an extension function on a type. It runs on the object reference
    // into the expression and returns the object reference on completion.
    fun apply() {

        data class Student(var name: String, var rollNumber: Int, var department: String, var address: String)
        val student = Student("Omar", 26, "cse", "Mukalla")
        student.apply {
            name = "Abdullah"
            rollNumber = 51
            department = "it"
            address = "hadramoot"
        }
        print(student)// prints Student(name=Abdullah, rollNumber=51, department=it, address=hadramoot)
    }



    //let takes the object. (it) is invoked
    // upon as the parameter and returns the result
    // of the lambda expression and also returned as an argument.
    fun let() {

        val name = "abdullah"
        name.let {
            println("$it alamodi")
            val length = name.length
            print(length)
            //Prints
            //abdullah alamodi
            //16
        }

    }


    //run used to override values
    fun run() {
        var tutorial = "Abdullah"
        println(tutorial) //Abdullah
        tutorial = run {
            tutorial = "This is run function"
            tutorial
        }
        println(tutorial) //This is run function
    }


    //with is used to change instance properties without the need to call
    // dot operator over the reference every time. it takes an argument.
    fun with() {
        data class Student(var name: String, var rollNumber: Int, var department: String, var address: String)
        val student = Student("Abdullah", 26, "cis", "mukall")
        with(student) {
            name = "Abdullah"
            rollNumber = 41
            department = "it"
            address = "hadramoot"
        }
        print(student)// prints Student(name=Abdullah, rollNumber=41, department=it, address=hadramoot)

    }


    //also expressions do some
    // additional processing on the object it was invoked.
    //Unlike let, it returns the original object instead
    // of any new return data. Hence the return data has always the same type.
    fun also() {

        data class Person(var name: String, var tutorial: String)
        val person = Person("Abdullah", "Kotlin")
        val l = person.let { it.tutorial = "Android" }
        val al = person.also { it.tutorial = "Android" }
        println(l) // prints kotlin.Unit
        println(al) //prints Person(name=Abdullah, tutorial=Android)
        println(person) //prints Person(name=Abdullah, tutorial=Android)
    }

    fun takeIf() {
        // take the new value if match the condition.
        val phoneNumber = "8899665544";
        val number = phoneNumber.takeIf { it.matches("[0-9]+".toRegex()) }

    }
}

class InfixFunctionsNotation {
    //standard library infix functions
    public fun SLInfixFunction(){
    var x = 1 in 1..10; // check if 1 in the range;
        println("var x = 1 in 1..10  =  $x");
    }



    //user defined functions
    public fun UDInfixFunction(){
        infix fun Int.add(b : Int) : Int = this + b;
        val y = 10 add 20        // infix call
        println("val y = 10 add 20  = $y");
    }






}

class MemberFunctions {

    inline fun inlineFunction(x:Int,y:Int):Int { return x+y; }

    fun localFunction() {
        //local function
        fun hello(){
            println("hello this is a local function");
        }
    }

    fun lambdaFunction() {
        var square= { x:Int -> x*x }
        println("from lambda fun square={x:Int -> x*x)} x=3 = ${square(3)}");
    }
}

class UserDefinedFunctions:()->Unit {

    //anonymousFunction
    fun anonymousFun() {
        { println("this is anonymous function") }();
    }


    // function type

    //explicitType
    fun myFun(){
        println("this is explicit function ");
    }



    //typeInterface
    override fun invoke() {
        println(" this is type interface");
    }

}