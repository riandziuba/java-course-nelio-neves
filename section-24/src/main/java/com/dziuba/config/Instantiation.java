package com.dziuba.config;

import com.dziuba.domain.Post;
import com.dziuba.domain.User;
import com.dziuba.dto.AuthorDTO;
import com.dziuba.dto.CommentDTO;
import com.dziuba.repository.PostRepository;
import com.dziuba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        this.postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        this.userRepository.saveAll((Arrays.asList(maria, alex, bob)));

        Post postOne = new Post("Partiu viagem", null, sdf.parse("21/03/2018"), "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post postTwo = new Post("Bom dia", null, sdf.parse("23/03/2018"), "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO commentOne = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO commentTwo = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO commentThree = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        postOne.addComment(commentOne);
        postOne.addComment(commentTwo);
        postTwo.addComment(commentThree);

        this.postRepository.saveAll(Arrays.asList(postOne, postTwo));

        maria.addPost(postOne);
        maria.addPost(postTwo);

        userRepository.save(maria);
    }
}
