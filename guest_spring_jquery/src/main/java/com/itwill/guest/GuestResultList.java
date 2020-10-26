package com.itwill.guest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@XmlRootElement(name = "guestList")
@JacksonXmlRootElement(localName = "guest_list")
public class GuestResultList {
	private List<Guest> guestList;
	
	@XmlElement(name="guest")
	@JacksonXmlProperty(localName = "guest")
	public List<Guest> getGuestList() {
		return guestList;
	}

	public void setGuestList(List<Guest> guestList) {
		this.guestList = guestList;
	}

}
