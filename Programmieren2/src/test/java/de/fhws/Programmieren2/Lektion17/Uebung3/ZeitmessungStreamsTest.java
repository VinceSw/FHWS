package de.fhws.Programmieren2.Lektion17.Uebung3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ZeitmessungStreamsTest
{
	ZeitmessungStreams zs = new ZeitmessungStreams();
	
	@Test
	void testCopyMusicFile()
	{
		for(int i = 0; i < 100; i++)
		{
			UserInputMock uim = new UserInputMock("C:\\Users\\swigl\\Music\\Push It.mp3");
			uim.setUserInputMock("D:\\FHWS\\Semester2\\SU_Programmieren2\\Lektion17\\Uebung3\\Push It.mp3");
			assertTrue(zs.copyMusicFile(uim));
		}
	}
}
