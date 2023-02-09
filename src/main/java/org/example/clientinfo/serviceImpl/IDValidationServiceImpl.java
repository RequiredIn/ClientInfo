package org.example.clientinfo.serviceImpl;

import org.example.clientinfo.service.IDValidationService;
import org.springframework.stereotype.Service;

@Service
public class IDValidationServiceImpl implements IDValidationService {
    public boolean validateClientIdNumber(String idNumber) {
        int sumAtOddIndex = 0, sumAtIndexEven = 0, _doubled;
        int summation;
        int length = idNumber.length() - 1;
        char[] chars = idNumber.toCharArray();
        String check = idNumber.substring(12);
        for (int index = 0; index < length; index++) {
            if (index % 2 == 0) {
                String numString = String.valueOf(chars[index]);
                int numbers = Integer.valueOf(numString);
                sumAtOddIndex += numbers;
            } else if (index % 2 != 0) {
                String numString = String.valueOf(chars[index]);
                int numbers = Integer.valueOf(numString);
                int doubled = numbers * 2;
                if (doubled > 9) {
                    _doubled = doubled - 9;
                } else {
                    _doubled = doubled;
                }
                sumAtIndexEven += _doubled;
            }
        }
        summation = sumAtOddIndex + sumAtIndexEven;
        int checksum = Integer.valueOf(check);
        if ((summation * 9) % 10 == checksum)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;

    }
}