public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Vector3D normalize() {
        double magnitude = getMagnitude();
        if (magnitude == 0) {
            throw new IllegalStateException("Cannot normalize a zero vector.");
        }
        return new Vector3D(x/magnitude, y/magnitude, z/magnitude);
    }

    public Vector3D add(Vector3D vector) {
        return new Vector3D(x + vector.getX(), y + vector.getY(), z + vector.getZ());
    }

    public Vector3D multiply(double scalar) {
        return new Vector3D(x * scalar, y * scalar, z * scalar);
    }

    public double dotProduct(Vector3D vector) {
        return x * vector.getX() + y * vector.getY() + z * vector.getZ();
    }

    public double angleBetween(Vector3D vector) {
        double dotProduct = this.dotProduct(vector);
        double magnitudes = this.getMagnitude() * vector.getMagnitude();
        if (magnitudes == 0) {
            throw new IllegalStateException("Cannot calculate angle with a zero vector.");
        }
        return Math.toDegrees(Math.acos(dotProduct / magnitudes));
    }

    public Vector3D crossProduct(Vector3D vector) {
        return new Vector3D(this.y * vector.z - this.z * vector.y,
                            this.z * vector.x - this.x * vector.z,
                            this.x * vector.y - this.y * vector.x);
    }
}
