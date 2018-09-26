package com.apap.tutorial3.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.apap.tutorial3.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService{
	private List<PilotModel> archivePilot;
	
	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}

	@Override
	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);
	}

	@Override
	public List<PilotModel> getPilotList() {
		return archivePilot;
	}

	/** Method menerima licenseNumber dan mengemmbalikan objek pilotmodel dari 
	 * licenseNumber tersebut, jika tidak ada maka null
	 */
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		PilotModel pilotDetail = null;
		for (PilotModel pilot : archivePilot) {
			if ((pilot.getLicenseNumber()).equals(licenseNumber)) {
				pilotDetail = pilot;
				break;
			}
		}
		return pilotDetail;
	}
	
	public PilotModel getPilotDetailByID(String id) {
		PilotModel pilotDetail = null;
		for (PilotModel pilot : archivePilot) {
			if ((pilot.getId()).equals(id)) {
				pilotDetail = pilot;
				break;
			}
		}
		return pilotDetail;
	}
	
	public void deletePilot(PilotModel pilot) {
		archivePilot.remove(pilot);
	}
}
