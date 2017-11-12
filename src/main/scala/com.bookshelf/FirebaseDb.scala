package com.bookshelf

import java.io.FileInputStream
import com.google.firebase.FirebaseOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.database._
import com.google.firebase.auth.FirebaseCredentials

class FirebaseDb(credentialsFile: String, dbUrl: String) {

  initializeFirebaseApp()

  private def initializeFirebaseApp(): Unit = {
    val serviceAccount: FileInputStream = new FileInputStream(credentialsFile)
    val options: FirebaseOptions = new FirebaseOptions.Builder()
      .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
      .setDatabaseUrl(dbUrl)
      .build()

    FirebaseApp.initializeApp(options)
  }

  def createReference(): DatabaseReference = {
    val ref: DatabaseReference = FirebaseDatabase
      .getInstance()
      .getReference()
    ref.addListenerForSingleValueEvent(new ValueEventListener() {
      override def onDataChange(dataSnapshot: DataSnapshot) {
        val document: Object = dataSnapshot.getValue()
        println("_>_>_>")
        println(document)
        println("<_<_<_")
      }
      override def onCancelled(error: DatabaseError) {
        println("CANCELLED")
      }
    })

    ref
  }

  def getTableRef(tableName: String): DatabaseReference = {
    val ref: DatabaseReference = createReference()
    val usersRef: DatabaseReference = ref.child(tableName)
    usersRef
  }

  def addToTable(ref: DatabaseReference)(tableChild: String, childFields: Model): Unit = {
    ref.child(tableChild).setValueAsync(childFields)
  }

}

object FirebaseDb {

  val DB_CREDENTIALS = "src/main/resources/firebasecred.json"
  val DB_URL = "https://blol random.firebaseio.com"

  val TBL_USERS = "users"

  def addToUsersTable(tableChild: String, childFields: Model) = {

    val fb = new FirebaseDb(DB_CREDENTIALS, DB_URL)
    val usersRef = fb.getTableRef(TBL_USERS)

    fb.addToTable(usersRef)(tableChild, childFields)
  }
}