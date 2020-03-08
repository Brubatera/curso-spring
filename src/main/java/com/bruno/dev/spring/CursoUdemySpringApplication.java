package com.bruno.dev.spring;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import lombok.AllArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.dev.spring.domain.Address;
import com.bruno.dev.spring.domain.BilletPayment;
import com.bruno.dev.spring.domain.Category;
import com.bruno.dev.spring.domain.City;
import com.bruno.dev.spring.domain.CreditCardPayment;
import com.bruno.dev.spring.domain.Customer;
import com.bruno.dev.spring.domain.CustomerOrder;
import com.bruno.dev.spring.domain.Payment;
import com.bruno.dev.spring.domain.Product;
import com.bruno.dev.spring.domain.State;
import com.bruno.dev.spring.domain.enums.CustomerType;
import com.bruno.dev.spring.domain.enums.PaymentState;
import com.bruno.dev.spring.repositories.RepositoryAddress;
import com.bruno.dev.spring.repositories.RepositoryCategory;
import com.bruno.dev.spring.repositories.RepositoryCity;
import com.bruno.dev.spring.repositories.RepositoryCustomer;
import com.bruno.dev.spring.repositories.RepositoryOrder;
import com.bruno.dev.spring.repositories.RepositoryPayment;
import com.bruno.dev.spring.repositories.RepositoryProduct;
import com.bruno.dev.spring.repositories.RepositoryState;

@AllArgsConstructor
@SpringBootApplication
public class CursoUdemySpringApplication implements CommandLineRunner {

	private RepositoryCategory repositoryCategory;
	private RepositoryProduct repositoryProduct;
	private RepositoryState repositoryState;
	private RepositoryCity repositoryCity;
	private RepositoryCustomer repositoryCustomer;
	private RepositoryAddress repositoryAddress;
	private RepositoryOrder repositoryOrder;
	private RepositoryPayment repositoryPayment;

	public static void main(String[] args) {
		SpringApplication.run( CursoUdemySpringApplication.class, args );
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = Category.builder()
				.name( "Informática" )
				.products( new ArrayList<>() )
				.build();

		Category cat2 = Category.builder()
				.name( "Escritório" )
				.products( new ArrayList<>() )
				.build();

		Product p1 = Product.builder()
				.name( "Computador" )
				.price( 2000.00 )
				.categories( new ArrayList<>() )
				.build();

		Product p2 = Product.builder()
				.name( "Impressora" )
				.price( 800.00 )
				.categories( new ArrayList<>() )
				.build();

		Product p3 = Product.builder()
				.name( "Mouse" )
				.price( 80.00 )
				.categories( new ArrayList<>() )
				.build();

		cat1.getProducts().addAll( Arrays.asList( p1, p2, p3 ) );
		cat2.getProducts().addAll( Collections.singletonList( p2 ) );

		p1.getCategories().addAll( Collections.singletonList( cat1 ) );
		p2.getCategories().addAll( Arrays.asList( cat1, cat2 ) );
		p3.getCategories().addAll( Collections.singletonList( cat1 ) );

		repositoryCategory.saveAll( Arrays.asList( cat1, cat2 ) );
		repositoryProduct.saveAll( Arrays.asList( p1, p2, p3 ) );

		State st1 = State.builder()
				.name( "Minas Gerais" )
				.cities( new ArrayList<>() )
				.build();

		State st2 = State.builder()
				.name( "São Paulo" )
				.cities( new ArrayList<>() )
				.build();

		City c1 = City.builder()
				.name( "Uberlândia" )
				.state( st1 )
				.build();

		City c2 = City.builder()
				.name( "São Paulo" )
				.state( st2 )
				.build();

		City c3 = City.builder()
				.name( "Campinas" )
				.state( st2 )
				.build();

		st1.getCities().addAll( Collections.singletonList( c1 ) );
		st2.getCities().addAll( Arrays.asList( c2, c3 ) );

		repositoryState.saveAll( Arrays.asList( st1, st2 ) );
		repositoryCity.saveAll( Arrays.asList( c1, c2, c3 ) );

		Customer cl1 = new Customer(
				null,
				"Maria Silva",
				"maria@gmail.com",
				"65578468179",
				CustomerType.PHYSICALPERSON );

		cl1.getTelephones().addAll( Arrays.asList( "9999999", "999999998" ) );

		Address ad1 = Address.builder()
				.street( "Rua flores" )
				.number( "300" )
				.complementStreet( "Apartamento 303" )
				.neighborhood( "Jardim" )
				.zipCode( "12912982" )
				.customer( cl1 )
				.city( c1 )
				.build();

		Address ad2 = Address.builder()
				.street( "Rua matos" )
				.number( "105" )
				.complementStreet( "Sala 800" )
				.neighborhood( "Centro" )
				.zipCode( "12913333" )
				.customer( cl1 )
				.city( c2 )
				.build();

		cl1.getAddresses().addAll( Arrays.asList( ad1, ad2 ) );

		repositoryCustomer.save( cl1 );
		repositoryAddress.saveAll( Arrays.asList( ad1, ad2 ) );

		CustomerOrder cso1 = CustomerOrder.builder()
				.instant( LocalDate.of( 2020, 03, 8 ).atTime( 18, 17, 22 ) )
				.customer( cl1 )
				.deliveryAddress( ad1 )
				.build();

		CustomerOrder cso2 = CustomerOrder.builder()
				.instant( LocalDate.of( 2020, 03, 8 ).atTime( LocalTime.now() ) )
				.customer( cl1 )
				.deliveryAddress( ad2 )
				.build();

		Payment pay1 = new CreditCardPayment(
				null,
				PaymentState.PAID,
				cso1,
				6 );
		cso1.setPayment( pay1 );

		Payment pay2 = new BilletPayment(
				null,
				PaymentState.PENDING,
				cso2,
				LocalDate.now(),
				null );
		cso2.setPayment( pay2 );

		cl1.getOrders().addAll( Arrays.asList( cso1, cso2 ) );

		repositoryOrder.saveAll( Arrays.asList( cso1, cso2 ) );
		repositoryPayment.saveAll( Arrays.asList( pay1, pay2 ) );
	}
}
