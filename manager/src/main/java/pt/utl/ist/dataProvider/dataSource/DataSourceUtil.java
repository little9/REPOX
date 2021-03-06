package pt.utl.ist.dataProvider.dataSource;

import pt.utl.ist.marc.Iso2709FileExtractStrategy;
import pt.utl.ist.marc.MarcXchangeFileExtractStrategy;
import pt.utl.ist.metadataTransformation.MetadataFormat;

import java.util.Map;

/**
 * Created by IntelliJ IDEA. User: Gilberto Pedrosa Date: 20-07-2011 Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
public class DataSourceUtil {
    /**
     * Create IdPolicy
     * 
     * @param recordIdPolicyClass
     * @param identifierXpath
     * @param namespaces
     * @return RecordIdPolicy
     */
    public static RecordIdPolicy createIdPolicy(String recordIdPolicyClass, String identifierXpath, Map<String, String> namespaces) {
        RecordIdPolicy recordIdPolicy = null;
        if (recordIdPolicyClass.equals(IdGeneratedRecordIdPolicy.IDGENERATED)) {
            recordIdPolicy = new IdGeneratedRecordIdPolicy();
        } else if (recordIdPolicyClass.equals(IdProvidedRecordIdPolicy.IDPROVIDED)) {
            recordIdPolicy = new IdProvidedRecordIdPolicy();
        } else if (recordIdPolicyClass.equals(IdExtractedRecordIdPolicy.IDEXTRACTED)) {
            recordIdPolicy = new IdExtractedRecordIdPolicy(identifierXpath, namespaces);
        }
        return recordIdPolicy;
    }

    /**
     * @param metadataFormat
     * @param isoFormat
     * @return FileExtractStrategy
     */
    public static FileExtractStrategy extractStrategyString(String metadataFormat, String isoFormat) {
        if (metadataFormat.equals(MetadataFormat.ISO2709.toString())) {
            return new Iso2709FileExtractStrategy(isoFormat);
        } else if (metadataFormat.equals(MetadataFormat.MarcXchange.toString())) {
            return new MarcXchangeFileExtractStrategy();
        } else {
            return new SimpleFileExtractStrategy();
        }
    }
}
