package com.gw.callingcard.data.responses

data class User(  val api_token: Any,
                  val created_at: String,
                  val current_team_id: Any,
                  val device_token: String,
                  val email: String,
                  val email_verified_at: Any,
                  val id: Int,
                  val name: String,
                  val phonenumber: String,
                  val profile_photo_path: Any,
                  val profile_photo_url: String,
                  val updated_at: String,
                  val user_role_id: String) {

}
