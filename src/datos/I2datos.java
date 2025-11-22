/**
Look:
http://www.independent-software.com/dbase-dbf-dbt-file-format.html

Overall .dbf file structure

A .dbf file consist of three blocks:

    -- Header
    -- List of field_descriptors
    -- List of records

The field_descriptors follow directly after the header data, while the header contains an offset to the start of the record data.
 */
package datos;
/**
 *
 * @author k
 */
public interface I2datos {
    
    public static final String DBF_TYPEFILE = ".dbf";
    
//    public final int _LENGTH_OF_HEADER = 32; // 2023-07-30 -- length of "_bt" array of bytes
//    public final int _TERMINATOR_FIELDS_ARRAY = 0x0D; // 2024-02-04 -- _TERMINATOR_FIELD_DESCRIPTOR_ARRAY
//    public final int _EOF = 0x1A; // 2024-02-04 -- _END_OF_FILE
        
    public abstract String getFileName();
    public abstract String getHeaderDump();
    public abstract String getFileInfo();
    public abstract String printListFields();
}
