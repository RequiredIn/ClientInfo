package org.example.clientinfo.serviceImpl;

import org.example.clientinfo.entity.Client;
import org.example.clientinfo.exception.ApiException;
import org.example.clientinfo.exception.ResourceNotFoundException;
import org.example.clientinfo.repository.ClientRepository;
import org.example.clientinfo.service.IDValidationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class IDValidationServiceTest {

    @InjectMocks
    IDValidationServiceImpl idValidationServiceImpl;

    @Test
    public void testForValidIdNumber(){
        String idNumber = "0311251002094";
        boolean response = idValidationServiceImpl.validateClientIdNumber(idNumber);

        Assert.assertNotNull(response);
        Assert.assertTrue(response);
    }

    @Test
    public void testForInValidIdNumber(){
        String idNumber = "0311251002092";
        boolean response = idValidationServiceImpl.validateClientIdNumber(idNumber);

        Assert.assertNotNull(response);
        Assert.assertFalse(response);
    }

    @ExtendWith(MockitoExtension.class)
    public static class ClientServiceImplTest {

        @InjectMocks
        ClientServiceImpl clientService;
        @Mock
        ClientRepository clientRepository;
        @Mock
        IDValidationService idValidationService;

        @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testGetAll() {
            given(clientRepository.findAll()).willReturn(Arrays.asList(new Client("12234444544", "Nik", "Thom", "SA", 12445656l)));
            List<Client> response = clientService.getAll();
            Assert.assertFalse(response.isEmpty());

        }

        @Test(expected = ApiException.class)
        public void testSaveClientWithMobileAlreadyExists() {
            given(clientRepository.existsByMobileNumber(12445656l)).willReturn(true);
            Client response = clientService.saveClient(getClinet());
            verify(clientRepository, times(1)).existsByMobileNumber(Mockito.anyLong());

        }

        @Test(expected = ApiException.class)
        public void testSaveClientWithInValidIDNumberError() {
            given(clientRepository.existsByMobileNumber(12445656l)).willReturn(false);
            given(idValidationService.validateClientIdNumber("1234567890123")).willReturn(false);

            Client response = clientService.saveClient(getClinet());

            verify(clientRepository, times(1)).existsByMobileNumber(Mockito.anyLong());
            verify(idValidationService, times(1)).validateClientIdNumber(Mockito.anyString());
        }

        @Test
        public void testSaveClientWithValidData() {
            given(clientRepository.existsByMobileNumber(12445656l)).willReturn(false);
            given(idValidationService.validateClientIdNumber("0311251002094")).willReturn(true);

            Client response = clientService.saveClient(getClinet());

            verify(clientRepository, times(1)).existsByMobileNumber(Mockito.anyLong());
            verify(idValidationService, times(1)).validateClientIdNumber(Mockito.anyString());
        }

        @Test
        public void testGetByIdNumber() {
            given(clientRepository.findById("0311251002094")).willReturn(Optional.of(getClinet()));
            List<Client> response = clientService.getClientByRequestParam("0311251002094");

            Assert.assertNotNull(response);
        }

        @Test
        public void testGetByMobileNumber() {
            given(clientRepository.findByMobileNumber(12445656l)).willReturn(Optional.of(getClinet()));
            List<Client> response = clientService.getClientByRequestParam("12445656");

            Assert.assertNotNull(response);
        }

        @Test
        public void testGetByFirstName() {
            given(clientRepository.findByFirstName("Nik")).willReturn(Optional.of(getClinet()));
            List<Client> response = clientService.getClientByRequestParam("Nik");

            Assert.assertNotNull(response);
        }

        @Test(expected = ResourceNotFoundException.class)
        public void testGetDetailsNoRecord() {
            List<Client> response = clientService.getClientByRequestParam("1233332443");

        }

        private Client getClinet() {
            return new Client("0311251002094", "Nik", "Thom", "SA", 12445656l);

        }
    }
}
