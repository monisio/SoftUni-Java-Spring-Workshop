package com.example.pathfinder.config;


import com.example.pathfinder.model.entity.CommentEntity;
import com.example.pathfinder.model.view.CommentViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class ApplicationBeanConfiguration {


   @Bean
   public ModelMapper modelMapperConfig(){
       ModelMapper modelMapper = new ModelMapper();

       modelMapper.typeMap(CommentEntity.class, CommentViewModel.class)
                .addMappings(m-> m.map(src-> src.getAuthor().getFullName(),CommentViewModel::setAuthorName));


       return modelMapper ;
   }



    @Bean
    public PasswordEncoder passwordEncoder(){

        return new Pbkdf2PasswordEncoder();

    }

}
