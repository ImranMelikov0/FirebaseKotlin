package com.imranmelikov.firebasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import java.util.EventListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database=FirebaseDatabase.getInstance()

        val refPerson=database.getReference("persons")

        val person=Persons("Android",18)
//        refPerson.push().setValue(person)
//        refPerson.child("-Ne9aigfKi16QxjBF6cq").removeValue()

//        val update=HashMap<String,Any>()
//        update["person_name"]="Mandroid"
////        update["person_age"]=19
//        refPerson.child("-Ne9_0kvbFH6mnyCtqdl").updateChildren(update)

        val search=refPerson.orderByChild("person_name").equalTo("Bandroid")
//        val search1=refPerson.limitToFirst(1)
//        val search2=refPerson.limitToLast(2)
//        val search3=refPerson.orderByChild("person_age").startAt(10.0).endAt(20.0)

        search.addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
              val dataSnapshot= snapshot.children 
                dataSnapshot.map {
                    val data = it.getValue(Persons::class.java)
                    if (data != null) {
                        val key = it.key
                        println("********")
                        println(key)
                        println(data.person_name)
                        println(data.person_age)
                    }
                }


            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }

        })
    }
}