package org.ocsinventory.android.sections;

import java.io.File;

import org.ocsinventory.android.actions.Utils;

import android.os.StatFs;
import android.text.format.DateFormat;

public class OCSStorage {

	private String  description;
	private long  disksize;
	private String  firmware;
	private String  manufacturer;
	private String  model;
	private String  name;
	private String  serialnumber;
	private String  type;

	public OCSStorage(File d, String description) {
		String pathESD = d.getPath();
		StatFs statfs = new StatFs(pathESD);
		long bs = statfs.getBlockSize();
		long bc = statfs.getBlockCount();

		this.description = description;
		this.disksize = bs * bc / 1048576L;
		
		this.firmware=null;
		this.manufacturer="NA";
		this.model="NA";
		this.name="NA";
		this.serialnumber=null;
		this.type="ROM";
		
	}

	/* Exemple Linux
<STORAGES>
      <DESCRIPTION>IDE</DESCRIPTION>
      <DISKSIZE></DISKSIZE>
      <FIRMWARE>801</FIRMWARE>
      <MANUFACTURER>PNY</MANUFACTURER>
      <MODEL>USB2.0 FD      </MODEL>
      <NAME></NAME>
      <SCSI_CHID></SCSI_CHID>
      <SCSI_COID></SCSI_COID>
      <SCSI_LUN></SCSI_LUN>
      <SCSI_UNID></SCSI_UNID>
      <SERIALNUMBER></SERIALNUMBER>
      <TYPE>disk</TYPE>
    </STORAGES>
	<!ELEMENT STORAGES (MANUFACTURER | NAME | MODEL | DESCRIPTION | TYPE | DISKSIZE | FIRMWARE | SERIALNUMBER)*>
	 */

	public String toXml() {
		StringBuffer strOut = new StringBuffer();
		strOut.append("    <STORAGES>\n");
		Utils.xmlLine(strOut, "DESCRIPTION", description);
		Utils.xmlLine(strOut, "DISKSIZE", String.valueOf(disksize));
		Utils.xmlLine(strOut, "FIRMWARE", firmware);
		Utils.xmlLine(strOut, "MANUFACTURER", manufacturer);
		Utils.xmlLine(strOut, "MODEL", model);
		Utils.xmlLine(strOut, "NAME", name);
		Utils.xmlLine(strOut, "SERIALNUMBER",serialnumber);
		Utils.xmlLine(strOut, "TYPE", type);
		/*
		Utils.xmlLine(strOut, "SCSI_CHID",null);
		Utils.xmlLine(strOut, "SCSI_COID",null);
		Utils.xmlLine(strOut, "SCSI_LUN",null);
		Utils.xmlLine(strOut, "SCSI_UNID",null);
		*/
		strOut.append("    </STORAGES>\n");
		return strOut.toString();
	}
	public String toString() {
		StringBuffer strOut = new StringBuffer();
		strOut.append("*STORAGE*\n");
		Utils.strLine(strOut, "DESCRIPTION", description);
		Utils.strLine(strOut, "DISKSIZE", String.valueOf(disksize));
		Utils.strLine(strOut, "FIRMWARE", firmware);
		Utils.strLine(strOut, "MANUFACTURER", manufacturer);
		Utils.strLine(strOut, "MODEL", model);
		Utils.strLine(strOut, "NAME", name);
		Utils.strLine(strOut, "SERIALNUMBER",serialnumber);
		Utils.strLine(strOut, "TYPE", type);
		return strOut.toString();
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDisksize() {
		return disksize;
	}

	public void setDisksize(long disksize) {
		this.disksize = disksize;
	}

	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}