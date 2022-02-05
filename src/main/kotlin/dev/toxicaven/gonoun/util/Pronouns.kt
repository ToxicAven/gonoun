package dev.toxicaven.gonoun.util

import dev.toxicaven.gonoun.Gonoun

enum class Pronouns(val response: String, val embed: String) {
    HH("hh", " would prefer if you would use He/Him pronouns!"),
    HI("hi", " would prefer if you would use He/It pronouns!"),
    HS("hs", " would prefer if you would use He/She pronouns!"),
    HT("ht", " would prefer if you would use He/They pronouns!"),
    IH("ih", " would prefer if you would use It/Him pronouns!"),
    II("ii", " would prefer if you would use It/Its pronouns!"),
    IS("is", " would prefer if you would use It/She pronouns!"),
    IT("it", " would prefer if you would use It/They pronouns!"),
    SHH("shh", " would prefer if you would use She/He pronouns!"),
    SH("sh", " would prefer if you would use She/Her pronouns!"),
    SI("si", " would prefer if you would use She/It pronouns!"),
    ST("st", " would prefer if you would use She/They pronouns!"),
    TH("th", " would prefer if you would use They/He pronouns!"),
    TI("ti", " would prefer if you would use They/It pronouns!"),
    TS("ts", "  would prefer if you would use They/She pronouns!"),
    TT("tt", " would prefer if you would use They/Them pronouns!"),
    ANY("any", " uses any pronouns!"),
    OTHER("other"," uses Other pronouns, maybe ask them what pronouns they use?"),
    ASK("ask", " would prefer if you ask for what pronouns they use!"),
    AVOID("avoid"," doesn't want you to use pronouns, just use their name!"),
    UNSPECIFIED("unspecified","I don't know that person's pronouns, ask them to set their pronouns using `${Gonoun().prefix}set`!")
}