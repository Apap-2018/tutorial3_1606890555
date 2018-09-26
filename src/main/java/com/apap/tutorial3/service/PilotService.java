package com.apap.tutorial3.service;

import java.util.List;
import com.apap.tutorial3.model.PilotModel;

/** Service ini merupakan interface yang mendefinisikan method-method apa saja yang dapat
dilakukan untuk memanipulasi kelas Pilot. Dari method-method di atas, Anda dapat melihat
data Pilot berdasarkan nomor lisensinya, melihat seluruh data Pilot, dan menambahkan Pilot
baru
 */
public interface PilotService {
	void addPilot (PilotModel pilot);
	void deletePilot (PilotModel pilot);
	List<PilotModel> getPilotList();
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	PilotModel getPilotDetailByID(String id);
}
