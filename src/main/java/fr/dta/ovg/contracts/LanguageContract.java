/* Language Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** LANGUAGE CONTRACT - Constants Term.*/
public final class LanguageContract {

    /** Private empty constructor of LanguageContract.*/
    private LanguageContract() {
        // nothing here.
    }

    // REPOSITORY SQL REQUESTS
    /** Request if language entity exists by label.*/
    public static final String EXISTS_BY_LABEL = "SELECT COUNT(h) > 0"
                                                + " FROM Language h"
                                                + " WHERE LOWER(h.label) = LOWER(:#{#s.label}) "
                                                + "AND (:#{#s.id} = NULL "
                                                + "OR h.id != :#{#s.id})";

    // TABLE DEFINITION
    /** Table app_languages. */
    public static final String TABLE = "app_languages";
    /** Table app_languages API description. */
    public static final String TABLE_API = "Describes a Language for our system.";


    // COLUMNS DEFINITION
    /** Column lang_label.*/
    public static final String COL_LABEL = "lang_label";
    /** Column lang_label API Description.*/
    public static final String COL_LABEL_API = "The language label to create.";
    /** Column lang_label length. */
    public static final int COL_LABEL_LENGTH = 50;

    // UserLanguage ENTITY - JOIN TABLE
    /** Join Table app_us_lang_lvl. */
    public static final String JOIN_TABLE = "app_us_lang_lvl";

    /** Column us_lang_lvl. */
    public static final String COL_US_LANG_LVL = "us_lang_lvl";
    /** Column us_lang_lvl API Description. */
    public static final String COL_US_LANG_LVL_API = "The language level of the user.";

    /** Mapped by "language".*/
    public static final String MAPPED_BY_LANGUAGE = "language";
}
