class App
{
    interface Character
    {
        int getPowerPoints();
        int getDexterityPoints();
    }

    enum Gender implements Character
    {
        MALE( 10, 4 ),
        FEMALE( 5, 7 );

        private int powerPoints = 0;
        private int dexterityPoints = 0;

        Gender( int powerPoints, int dexterityPoints )
        {
            this.powerPoints = powerPoints;
            this.dexterityPoints = dexterityPoints;
        }

        public int getPowerPoints()
        {
            return powerPoints;
        }

        public int getDexterityPoints()
        {
            return dexterityPoints;
        }
    }

    public static void main(String[] args) {
        for ( Gender i: Gender.values() )
        {
            System.out.println(i.getDexterityPoints());
            System.out.println(i.getPowerPoints());
        }
    }
}
