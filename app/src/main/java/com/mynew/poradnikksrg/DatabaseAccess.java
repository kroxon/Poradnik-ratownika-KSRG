package com.mynew.poradnikksrg;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseAccess {
    public static final String SUBSTANCE_TABLE = "SUBSTANCE_TABLE";
    public static final String PROCEDURE_TABLE = "PROCEDURE_TABLE";
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DataBaseHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance == null)
            instance = new DatabaseAccess(context);
        return instance;
    }

    // to open database
    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    //closing addtabase connection
    public void close(){
        if(db!=null)
            this.db.close();
    }


    public List<ProcedureClass> getEveryProc() {
        List<ProcedureClass> returnList = new ArrayList<>();

        // get data from database
        String querryString = "SELECT  * FROM " + PROCEDURE_TABLE;
        Cursor cursor = db.rawQuery(querryString, null);

        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new Procedure obj-ect. Put them into the return list
            do {
                int procedureID = cursor.getInt(0);
                String procedureNumber = cursor.getString(1);
                String procedureDescription = cursor.getString(2);
                procedureDescription = procedureDescription.replaceAll("\n", "");
                String procedureForE = cursor.getString(3);
                String procedureEffects = cursor.getString(4);
                String procedureRelease = cursor.getString(5);
                String procedureClothing = cursor.getString(6);
                String pp = cursor.getString(7);
                String procedureEvacuation = cursor.getString(8);
                String procedureFire = cursor.getString(9);
                String procedureEorL = cursor.getString(10);
                String procedureFirstAid = cursor.getString(11);

                ProcedureClass newProcedureClass = new ProcedureClass(procedureID, procedureNumber, procedureDescription, procedureForE, procedureEffects,
                        procedureRelease, procedureClothing, procedureEvacuation, procedureFire, procedureEorL, procedureFirstAid);
                returnList.add(newProcedureClass);
            } while (cursor.moveToNext());
        } else {
            //failure. do not add anything to the list
        }
        cursor.close();
//        db.close();
        return returnList;
    }

    public List<Substances> getEverySubst() {
        List<Substances> returnList = new ArrayList<>();

        //get data from database
        String querryString = "SELECT * FROM " + SUBSTANCE_TABLE;
        Cursor cursor = db.rawQuery(querryString, null);

        if (cursor.moveToFirst()) {
            // loop through the cursor and create Substance object. Put them inti the return list
            do {
                int substanceID = cursor.getInt(0);
                String substanceONZ = cursor.getString(1);
                String substanceProcedure = cursor.getString(2);
                String substanceName = cursor.getString(3);

                Substances newSubstance = new Substances(substanceID, substanceONZ, substanceProcedure, substanceName);
                returnList.add(newSubstance);
            } while (cursor.moveToNext());
        } else {
            System.out.println("nothing");
            // failure. do not add anthing to the list
        }
        cursor.close();
//        db.close();
        return returnList;
    }
}
