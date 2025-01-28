package br.com.ifba.api;

import br.com.ifba.api.dto.EnderecoDto;
import br.com.ifba.api.service.ApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {


        ApiService apiService = new ApiService();
        try {
            System.out.println(apiService.getEndereco("01001000"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}