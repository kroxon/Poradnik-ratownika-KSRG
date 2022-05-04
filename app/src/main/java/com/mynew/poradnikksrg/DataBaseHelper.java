package com.mynew.poradnikksrg;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

//public class DataBaseHelper extends SQLiteOpenHelper {
public class DataBaseHelper extends SQLiteAssetHelper {

    public static final String PROCEDURE_TABLE = "PROCEDURE_TABLE";
    public static final String COLUMN_PROCEDURE_NUMBER = "PROCEDURE_NUMBER";
    public static final String COLUMN_PROCEDURE_DESCRIPTION = "PROCEDURE_DESCRIPTION";
    public static final String COLUMN_PROCEDURE_FORE = "PROCEDURE_FORE";
    public static final String COLUMN_PROCEDURE_EFFECTS = "PROCEDURE_EFFECTS";
    public static final String COLUMN_PROCEDURE_RELEASE = "PROCEDURE_RELEASE";
    public static final String COLUMN_PROCEDURE_CLOTCHING = "PROCEDURE_CLOTCHING";
    public static final String COLUMN_PROCEDURE_EVACUATION = "PROCEDURE_EVACUATION";
    public static final String COLUMN_PROCEDURE_FIRE = "PROCEDURE_FIRE";
    public static final String COLUMN_PROCEDURE_EORL = "PROCEDURE_EORL";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_PROCEDURE_FIRSTAID = "PROCEDURE_FIRSTAID";
    public static final String SUBSTANCE_TABLE = "SUBSTANCE_TABLE";
    public static final String COLUMN_SUBSTANCE_ONZNUMBER = "SUBSTANCE_ONZNUMBER";
    public static final String COLUMN_SUBSTANCE_PROC_NUMBER = "SUBSTANCE_PROC_NUMBER";
    public static final String COLUMN_SUBSTANCE_NAME = "SUBSTANCE_NAME";

    public static final int DATABASE_VERSION = 1;
    static String DB_PATH = "/data/data/com.mynew.poradnikksrg/databases/";
    static String DB_NAME = "procedures7.db";
    private SQLiteDatabase db;
//    private final Context mContext;

    public DataBaseHelper( Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
//        this.mContext = context;
    }
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String createTableStatement = "CREATE TABLE " + PROCEDURE_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PROCEDURE_NUMBER + " TEXT, " + COLUMN_PROCEDURE_DESCRIPTION +
//                " TEXT, " + COLUMN_PROCEDURE_FORE + " TEXT, " + COLUMN_PROCEDURE_EFFECTS + " TEXT, " + COLUMN_PROCEDURE_RELEASE + " TEXT, " + COLUMN_PROCEDURE_CLOTCHING + " TEXT," +
//                " TEXT, " + COLUMN_PROCEDURE_EVACUATION + " TEXT, " + COLUMN_PROCEDURE_FIRE + " TEXT, " + COLUMN_PROCEDURE_EORL + " TEXT, " + COLUMN_PROCEDURE_FIRSTAID + " TEXT)";
//
//        String createTableStatement2 = "CREATE TABLE " + SUBSTANCE_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SUBSTANCE_ONZNUMBER + " TEXT, " + COLUMN_SUBSTANCE_PROC_NUMBER + " TEXT," +
//                COLUMN_SUBSTANCE_NAME + " TEXT)";
//
//        sqLiteDatabase.execSQL(createTableStatement);
//        sqLiteDatabase.execSQL(createTableStatement2);
////        try {
////            copyDataBase();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int newVersion, int oldVersion) {
////        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + PROCEDURE_TABLE);
////        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + SUBSTANCE_TABLE);
//        if (newVersion > oldVersion)
//        {
//            Log.v("Database Upgrade", "Database version higher than old.");
//            db_delete();
//        }
//    }
//
//
//    public List<ProcedureClass> getEveryProc() {
//        List<ProcedureClass> returnList = new ArrayList<>();
//
//        // get data from database
//        String querryString = "SELECT  * FROM " + PROCEDURE_TABLE;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(querryString, null);
//
//        if (cursor.moveToFirst()) {
//            // loop through the cursor (result set) and create new Procedure obj-ect. Put them into the return list
//            do {
//                int procedureID = cursor.getInt(0);
//                String procedureNumber = cursor.getString(1);
//                String procedureDescription = cursor.getString(2);
//                procedureDescription = procedureDescription.replaceAll("\n", "");
//                String procedureForE = cursor.getString(3);
//                String procedureEffects = cursor.getString(4);
//                String procedureRelease = cursor.getString(5);
//                String procedureClothing = cursor.getString(6);
//                String pp = cursor.getString(7);
//                String procedureEvacuation = cursor.getString(8);
//                String procedureFire = cursor.getString(9);
//                String procedureEorL = cursor.getString(10);
//                String procedureFirstAid = cursor.getString(11);
//
//                ProcedureClass newProcedureClass = new ProcedureClass(procedureID, procedureNumber, procedureDescription, procedureForE, procedureEffects,
//                        procedureRelease, procedureClothing, procedureEvacuation, procedureFire, procedureEorL, procedureFirstAid);
//                returnList.add(newProcedureClass);
//            } while (cursor.moveToNext());
//        } else {
//            //failure. do not add anything to the list
//        }
//        cursor.close();
//        db.close();
//        return returnList;
//    }
//
//    public List<Substances> getEverySubst() {
//        List<Substances> returnList = new ArrayList<>();
//
//        //get data from database
//        String querryString = "SELECT * FROM " + SUBSTANCE_TABLE;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(querryString, null);
//
//        if (cursor.moveToFirst()) {
//            // loop through the cursor and create Substance object. Put them inti the return list
//            do {
//                int substanceID = cursor.getInt(0);
//                String substanceONZ = cursor.getString(1);
//                String substanceProcedure = cursor.getString(2);
//                String substanceName = cursor.getString(3);
//
//                Substances newSubstance = new Substances(substanceID, substanceONZ, substanceProcedure, substanceName);
//                returnList.add(newSubstance);
//            } while (cursor.moveToNext());
//        } else {
//            System.out.println("nothing");
//            // failure. do not add anthing to the list
//        }
//        cursor.close();
//        db.close();
//        return returnList;
//    }
//    /**
//     * This method will create database in application package /databases
//     * directory when first time application launched
//     **/
//    public void createDataBase() throws IOException {
//        boolean mDataBaseExist = checkDataBase();
//        if (!mDataBaseExist) {
//            this.getReadableDatabase();
//            try {
//                copyDataBase();
//            } catch (IOException mIOException) {
//                mIOException.printStackTrace();
//                throw new Error("Error copying database");
//            } finally {
//                this.close();
//            }
//        }
//    }
//
//    /** This method checks whether database is exists or not **/
//    private boolean checkDataBase() {
//        try {
//            final String mPath = DB_PATH + DB_NAME;
//            final File file = new File(mPath);
//            return file.exists();
//        } catch (SQLiteException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * This method will copy database from /assets directory to application
//     * package /databases directory
//     **/
//    private void copyDataBase() throws IOException {
//        try {
//
//            InputStream mInputStream = mContext.getAssets().open(DB_NAME);
//            String outFileName = DB_PATH + DB_NAME;
//            OutputStream mOutputStream = new FileOutputStream(outFileName);
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = mInputStream.read(buffer)) > 0) {
//                mOutputStream.write(buffer, 0, length);
//            }
//            mOutputStream.flush();
//            mOutputStream.close();
//            mInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** This method open database for operations **/
//    public boolean openDataBase() throws SQLException {
//        String mPath = DB_PATH + DB_NAME;
//        db = SQLiteDatabase.openDatabase(mPath, null,
//                SQLiteDatabase.OPEN_READWRITE);
//        return db.isOpen();
//    }
//
//    /** This method close database connection and released occupied memory **/
//    @Override
//    public synchronized void close() {
//        if (db != null)
//            db.close();
//        SQLiteDatabase.releaseMemory();
//        super.close();
//    }
//
//    //delete database
//    public void db_delete()
//    {
//        File file = new File(DB_PATH + DB_NAME);
//        if(file.exists())
//        {
//            file.delete();
//            System.out.println("delete database file.");
//        }
//    }
}
