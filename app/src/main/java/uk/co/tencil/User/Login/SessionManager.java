package uk.co.tencil.User.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class SessionManager {

    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    //Static Variables
    private static final String IS_LOGIN = "IsLoggedIn";
    //variables
    SharedPreferences usersession;
    SharedPreferences.Editor editor;
    Context context;

    public SessionManager(Context _context) {
        context = _context;
        usersession = _context.getSharedPreferences ( "userLoginSession", Context.MODE_PRIVATE );
        editor = usersession.edit ();

    }

    public void createLoginSession(EditText email, EditText password) {
        editor.putBoolean ( IS_LOGIN, true );

        editor.putString ( KEY_EMAIL, String.valueOf ( email ) );
        editor.putString ( KEY_PASSWORD, String.valueOf ( password ) );

        editor.commit ();
    }

    public HashMap<String, String> getUsersDetailFromSession() {
        //Returns User data
        HashMap<String, String> userData = new HashMap<String, String> ();
        userData.put ( KEY_EMAIL, usersession.getString ( KEY_EMAIL, null ) );
        userData.put ( KEY_PASSWORD, usersession.getString ( KEY_PASSWORD, null ) );

        return userData;
    }

    public boolean checkLogin() {
        if (usersession.getBoolean ( IS_LOGIN, false )) {
            Toast.makeText ( context, "Check Login Works", Toast.LENGTH_SHORT ).show ();
            return true;
        } else {
            return false;
        }

    }

    public void logoutUserFromSession() {
        editor.clear ();
        editor.commit ();
    }


}

