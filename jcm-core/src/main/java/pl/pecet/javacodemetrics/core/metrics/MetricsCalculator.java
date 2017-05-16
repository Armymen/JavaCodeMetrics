package pl.pecet.javacodemetrics.core.metrics;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MetricsCalculator {

	private final InputStream inputStream;

	public void calculate() {
		try (final ZipInputStream zis = new ZipInputStream(inputStream)) {
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				// TODO handle calculate metrics for single entry
			}
		} catch (final IOException e) {
			// TODO exception handling
		}
	}

	public List<String> findMethodNames() {
		final List<String> methodNames = new ArrayList<>();

		final ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setSource("public class HelloClass { public static void main(String... args) {} void someMethod(){}}"
				.toCharArray());
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		cu.accept(new ASTVisitor() {
			@Override
			public boolean visit(final MethodDeclaration methodDeclaration) {
				methodNames.add(methodDeclaration.getName().getFullyQualifiedName());
				return super.visit(methodDeclaration);
			}
		});

		return methodNames;
	}
}
